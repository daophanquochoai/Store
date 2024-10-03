import {env} from "./Contranst.ts";

export const getSocialLoginUrl  = ( name ) => {
    return `${env.url.API_BASE_URL}/login/oauth2/code/github/${name}?redirect_uri=${env.url.OAUTH2_REDIRECT_URI}`
}