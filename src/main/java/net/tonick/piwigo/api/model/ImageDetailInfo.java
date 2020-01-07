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
 * Represents a more detailed view of image informations as extension of {@link ImageInfo}. Result payload of {@link net.tonick.piwigo.api.rest.RestService#getImageInfo(int)}.
 */
public class ImageDetailInfo extends ImageInfo implements Serializable {
    @SerializedName("filesize")
    public int filesize;
    @SerializedName("coi")
    public String coi;
    @SerializedName("representative_ext")
    public String representativeExt;
    @SerializedName("date_metadata_update")
    public String dateMetadataUpdate; // Todo: use real date
    @SerializedName("rating_score")
    public float ratingScore;
    @SerializedName("level")
    public String level;
    @SerializedName("md5sum")
    public String md5sum;
    @SerializedName("added_by")
    public int addedBy;
    @SerializedName("rotation")
    public String rotation;
    @SerializedName("latitude")
    public String latitude;
    @SerializedName("longitude")
    public String longitude;
    @SerializedName("last_modified")
    public String lastModified; // Todo: use real date
    @SerializedName("rates")
    public Rates rates;
    @SerializedName("tags")
    public List<Tag> tags;

    public class Rates {
        @SerializedName("score")
        public float score;
        @SerializedName("count")
        public int count;
        @SerializedName("average")
        public float average;
    }

    public class Tag {
        @SerializedName("id")
        public String id;
        @SerializedName("name")
        public String name;
        @SerializedName("url_name")
        public String urlName;
        @SerializedName("lastmodified")
        public String lastmodified; // Todo: use real date
        @SerializedName("url")
        public String url;
        @SerializedName("page_url")
        public String pageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ImageDetailInfo) {
            return id == ((ImageDetailInfo) o).id;
        }
        return super.equals(o);
    }

}
