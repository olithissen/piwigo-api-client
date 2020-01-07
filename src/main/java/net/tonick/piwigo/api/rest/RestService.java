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

import net.tonick.piwigo.api.model.CategoriesResponse;
import net.tonick.piwigo.api.model.ImageInfoResponse;
import net.tonick.piwigo.api.model.ImagesResponse;
import net.tonick.piwigo.api.model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * RestService interface for Piwigo web API
 */
public interface RestService {
    /**
     * Returns a {@link Call} object to perform the login with username/password and initializes the cookie store for subsequent calls
     *
     * <p>
     * Calls <pre>ws.php?method=pwg.session.login</pre>
     * </p>
     *
     * @param username username
     * @param password password
     * @return Call object for {@link LoginResponse}
     */
    @POST("ws.php?method=pwg.session.login")
    @FormUrlEncoded
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );

    /**
     * Returns a {@link Call} object to obtain all top level galleries
     *
     * <p>
     * Calls <pre>ws.php?method=pwg.categories.getList</pre>
     * </p>
     *
     * @return Call object for {@link CategoriesResponse}
     */
    @GET("ws.php?method=pwg.categories.getList")
    Call<CategoriesResponse> getCategories();

    /**
     * Returns a {@link Call} object to obtain galleries by id
     *
     * <p>
     * Calls <pre>ws.php?method=pwg.categories.getList</pre>
     * </p>
     *
     * @param categoryId The id of the the gallery to obtain. Can be <b>null</b> to get all categories
     * @return Call object for {@link CategoriesResponse}
     */
    @GET("ws.php?method=pwg.categories.getList")
    Call<CategoriesResponse> getCategories(
            @Query("cat_id") int categoryId
    );

    /**
     * Returns a {@link Call} object to obtain images from a gallery
     *
     * <p>
     * Calls <pre>ws.php?method=pwg.categories.getImages</pre>
     * </p>
     *
     * @param categoryId   id of the requested gallery
     * @param page         page index to read. Can be <b>null</b> to use API default
     * @param itemsPerPage number of images per page. Can be <b>null</b> to use API default
     * @return Call object for {@link ImagesResponse}
     */
    @GET("ws.php?method=pwg.categories.getImages")
    Call<ImagesResponse> getImages(
            @Query("cat_id") int categoryId,
            @Query("page") Integer page,
            @Query("per_page") Integer itemsPerPage
    );

    /**
     * Returns a {@link Call} object to obtain detailed info on a specific image
     *
     * <p>
     * Calls <pre>ws.php?method=pwg.images.getInfo</pre>
     * </p>
     *
     * @param imageId id of the requested image
     * @return Call object for {@link ImageInfoResponse}
     */
    @GET("ws.php?method=pwg.images.getInfo")
    Call<ImageInfoResponse> getImageInfo(
            @Query("image_id") int imageId
    );

}
