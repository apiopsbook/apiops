
import {pattern} from "@stoplight/spectral-functions";
import { DiagnosticSeverity } from "@stoplight/types";
import getOperationIdConvention  from './functions/get-operation-id-naming';
// import getOperationIdConvention from './functions/get-operation-id-naming-simple';


export default {
    rules: {
        'operationId-get-should-follow-naming-convention': {
            description: 'GET operations should have an operationId starting with retrieve or download',
            message: "GET operationId should follow naming convention. {{error}}",
            given: "$.paths[*].get.operationId",
            then: {
                function: getOperationIdConvention
            },
            severity: DiagnosticSeverity.Error,
        },

        'path-must-include-version': {
            description: 'Path must include the version',
            message: '{{description}}; {{property}} incorrect',
            severity: DiagnosticSeverity.Error,
            given: '$.paths[*]~',
            then: {
                function: pattern,
                functionOptions: {
                    match: '^/v[0-9]+/.*$'
                }
            }
        }
    },
};