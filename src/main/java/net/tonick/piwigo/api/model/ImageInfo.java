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

package net.tonick.piwigo.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a view of image informations as returned by {@link net.tonick.piwigo.api.rest.RestService#getImages(int, Integer, Integer)}
 */
public class ImageInfo implements Serializable {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("file")
    public String file;
    @SerializedName("comment")
    public Object comment;
    @SerializedName("author")
    public String author;
    @SerializedName("width")
    public int width;
    @SerializedName("height")
    public int height;
    @SerializedName("hit")
    public int hit;
    @SerializedName("element_url")
    public String elementUrl;
    @SerializedName("page_url")
    public String pageUrl;
    @SerializedName("date_creation")
    public String dateCreation; // Todo: Real date
    @SerializedName("date_available")
    public String dateAvailable; // Todo: Real date
    @SerializedName("derivatives")
    public Derivatives derivatives;
    @SerializedName("categories")
    public List<Category> categories;

    public class Category {
        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;
        @SerializedName("url")
        public String url;
        @SerializedName("permalink")
        public String permalink;
        @SerializedName("uppercats")
        public String uppercats; // Todo: Comma separated list
        @SerializedName("global_rank")
        public String globalRank;
        @SerializedName("page_url")
        public String pageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ImageInfo) {
            return id == ((ImageInfo) o).id;
        }
        return super.equals(o);
    }

}
