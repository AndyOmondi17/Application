
package com.example.final_application.models;

import java.util.List;

import com.example.final_application.models.Franchise;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GiantBombSearchResponse {

    @SerializedName("franchise")
    @Expose
    private List<Franchise> franchise = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GiantBombSearchResponse() {
    }

    /**
     * 
     * @param franchise
     */
    public GiantBombSearchResponse(List<Franchise> franchise) {
        super();
        this.franchise = franchise;
    }

    public List<Franchise> getFranchise() {
        return franchise;
    }

    public void setFranchise(List<Franchise> franchise) {
        this.franchise = franchise;
    }

}
