import {createRulesetFunction} from "@stoplight/spectral-core"
import type {IFunctionResult, RulesetFunctionContext} from '@stoplight/spectral-core';
type Input = string;
type Options = null;
export default createRulesetFunction<Input, Options>({
        input: {
            type: 'string'
        },
        errorOnInvalidInput: true,
        options: null,
    }, function operationIdConvention(targetValue, opts, context: RulesetFunctionContext) {
        const results: IFunctionResult[] = [];
        if (!(targetValue.startsWith("retrieve") || targetValue.startsWith("download"))) {
            results.push({
                message: `OperationId '${targetValue}' should start with 'retrieve' or 'download'.`,
                path: ['paths', '/v1/users', 'get', 'operationId'],
            });
        }
        return results;
    }
);