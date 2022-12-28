package dev.shahramkhandagi.locationlookup.objects;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;

public class RequestObject<T> extends JsonRequest<T> {
    private final Gson gson = new Gson();
    private final Class<T> classContent;
    private final Response.Listener<T> responseListener;


    // object request
    public RequestObject(int method, String url, Class<T> classContent, String json,
                         Response.Listener<T> responseListener, Response.ErrorListener errorListener) {
        super(method, url, json, responseListener, errorListener);
        this.classContent = classContent;
        this.responseListener = responseListener;
    }



    // override parsing Network Response //
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {

            String jsonContent = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    gson.fromJson(jsonContent, classContent),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException | JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }





    // override deliver response ///
    @Override
    protected void deliverResponse(T response) {
        responseListener.onResponse(response);
    }
}