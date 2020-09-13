import {ENV_URL} from './envConfig';

export function makeUrl(endpoint) {
    return ENV_URL+endpoint;
}