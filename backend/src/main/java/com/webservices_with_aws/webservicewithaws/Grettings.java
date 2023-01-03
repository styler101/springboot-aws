package com.webservices_with_aws.webservicewithaws;

import java.util.Objects;

public class Grettings {

    private final Long id;
    private  final String content;


    public Grettings(Long id, String content){
        super();
        this.content = content;
        this.id = id;
    }

    public Long getId() {
        return id;
    }



    public String getContent() {
        return content;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grettings grettings = (Grettings) o;
        return id.equals(grettings.id) && Objects.equals(content, grettings.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }
}
