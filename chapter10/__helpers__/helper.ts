// Largely based on code by Jakub Rozek, Stoplight.io
// License: Apache License 2.0
// https://github.com/stoplightio/spectral/blob/develop/packages/rulesets/src/__tests__/__helpers__/tester.ts

import { IRuleResult, Spectral, Document, Ruleset, RulesetDefinition } from '@stoplight/spectral-core';
import { httpAndFileResolver } from '@stoplight/spectral-ref-resolver';
import myRuleset from '../ruleset';

export type RuleName = keyof Ruleset['rules'];

type Scenarios = ReadonlyArray<
    Readonly<{
        scenarioName: string;
        apiDefinition: Record<string, unknown> | Document<unknown, any>;
        expectedErrors: ReadonlyArray<Partial<IRuleResult>>;
        mocks?: Record<string, Record<string, unknown>>;
    }>
>;

export default (ruleUnderTest: RuleName, scenarios: Scenarios): void => {
    describe(`Rule ${ruleUnderTest}`, () => {
        const concurrent = scenarios.every(scenario => scenario.mocks === void 0 || Object.keys(scenario.mocks).length === 0);
        for (const scenario of scenarios) {
            (concurrent ? it.concurrent : it)(scenario.scenarioName, async () => {
                const s = createWithRules([ruleUnderTest]);
                const doc = scenario.apiDefinition instanceof Document ? scenario.apiDefinition : JSON.stringify(scenario.apiDefinition);
                const errors = await s.run(doc);
                expect(errors.filter(({ code }) => code === ruleUnderTest)).toEqual(
                    scenario.expectedErrors.map(error => expect.objectContaining(error) as unknown),
                );
            });
        }
    });
};

export function createWithRules(rules: (keyof Ruleset['rules'])[]): Spectral {
    const s = new Spectral({ resolver: httpAndFileResolver });

    s.setRuleset({
        extends: [
            [myRuleset as RulesetDefinition, 'off'],
        ],
        rules: rules.reduce((obj, name) => {
            obj[name] = true;
            return obj;
        }, {}),
    });

    return s;
}