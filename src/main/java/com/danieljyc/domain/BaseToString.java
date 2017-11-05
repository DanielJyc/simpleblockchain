package com.danieljyc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by DanielJyc on 2017-11-05 21:16.
 */
public class BaseToString implements Serializable {

    private static final long serialVersionUID = -3531774999346449712L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
