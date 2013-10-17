package tradeking;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;import java.lang.Override;import java.lang.String;import java.lang.System;import java.lang.Thread;

public class TradeKingRequestThread extends Thread {
    private final Token accessToken;
    private final String requestUrl;
    private final OAuthService service;

    public TradeKingRequestThread(Token accessToken, String requestUrl, OAuthService service){
        this.accessToken = accessToken;
        this.requestUrl = requestUrl;
        this.service = service;
    }

    @Override
    public void run(){
        OAuthRequest request = new OAuthRequest(Verb.GET, requestUrl);
        service.signRequest(accessToken, request);
        Response response = request.send();
        System.out.println(response.getBody());
    }

}
