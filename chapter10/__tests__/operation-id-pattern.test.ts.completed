import { DiagnosticSeverity } from '@stoplight/types';
import testRule from '../__helpers__/helper';

testRule(  'operationId-get-should-follow-naming-convention', [
    {
        scenarioName: 'Valid case: GET operations should have an operationId starting with retrieve or download',
        apiDefinition: {
            openapi: '3.1.0',
            info: { version: '1.0' },
            paths: {
                '/v1/users': {
                    get: {
                        operationId: 'retrieveUsers',
                    }
                }
            }
        },
        expectedErrors: [],
    },
    {
        scenarioName: 'Invalid case: GET operations should have an operationId starting with retrieve or download',
        apiDefinition: {
            openapi: '3.1.0',
            info: { version: '1.0' },
            paths: {
                '/v1/users': {
                    get: {
                        operationId: 'listUsers',
                    }
                }
            }
        },
        expectedErrors: [
            {
                message: "GET operationId should follow naming convention. OperationId 'listUsers' should start with 'retrieve' or 'download'.",
                path: ['paths', '/v1/users', 'get', 'operationId'],
                severity: DiagnosticSeverity.Error,
            }
        ],
    }
]);