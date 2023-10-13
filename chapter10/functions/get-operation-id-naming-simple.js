

module.exports = function getOperationIdConvention(targetValue) {
    const results = [];
    if (!(targetValue.startsWith("retrieve") || targetValue.startsWith("download"))) {
        results.push({
            message: `OperationId '${targetValue}' should start with 'retrieve' or 'download'.`,
            path: ['paths', '/v1/users', 'get', 'operationId'],
        });
    }
    return results;
}