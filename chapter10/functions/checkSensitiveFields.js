const {RulesetFunctionContext} = require("@stoplight/spectral-core");
const jt = require('@tsmx/json-traverse');


module.exports = function log(targetValue, opts, context) {

    const callbacks = {
        processValue: (key, value, level, path, isObjectRoot, isArrayElement, cbSetValue) => {
            opts.sensitiveFields.forEach((sensitive) => {
                if (sensitive === key) {
                    let fieldPath = context.path.concat(path)
                    fieldPath.push(key)
                    results.push({
                        message: `Field: ${sensitive}`,
                        path: fieldPath,
                    });
                }
            });
        }
    };
    const results = [];
    jt.traverse(targetValue, callbacks);
    return results;
}