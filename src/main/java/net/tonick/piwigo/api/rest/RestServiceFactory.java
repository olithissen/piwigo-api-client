/*
 * MIT License
 *
 * Copyright (c) 2020 Oli Thissen
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.tonick.piwigo.api.rest;

import com.google.gson.Gson;
import okhttp3.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.CookieManager;
import java.net.CookiePolicy;

/**
 * A factory to create instaces of Piwigo {@link RestService}
 */
public class RestServiceFactory {
    private Gson gson;
    private CookieJar cookieJar;

    public RestServiceFactory() {
        this.gson = new Gson();
        CookieManager cm = new CookieManager();
        cm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        this.cookieJar = new JavaNetCookieJar(cm);
    }

    /**
     * Creates a {@link RestService} instance for the given URL
     *
     * @param url base URL of the Piwigo server without the trailing <pre>ws.php</pre>
     * @return An instance of {@link RestService}
     */
    public RestService createForUrl(String url) {
        OkHttpClient client = buildOkHttpClient();
        Retrofit retrofit = buildRetrofit(client, url);
        return retrofit.create(RestService.class);
    }

    private OkHttpClient buildOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request.Builder builder = chain.request().newBuilder();

                    HttpUrl.Builder urlBuilder = chain.request().url().newBuilder();
                    urlBuilder.addQueryParameter("format", "json");
                    builder.url(urlBuilder.build());

                    return chain.proceed(builder.build());
                })
                .cookieJar(cookieJar)
                .build();
    }

    private Retrofit buildRetrofit(OkHttpClient client, String baseUrl) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(client)
                .build();
    }
}
