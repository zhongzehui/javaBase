package com.zehui.base.enums;

import java.util.List;

/**
 * @author Niklaus
 */

public enum PizzaSize {

    /**
     * 枚举对象
     */
    EXTRA_SMALL("xs"),
    SMALL("s"),
    MEDIUM("m"),
    LARGE("l"),
    EXTRA_LARGE("xl"),
    ;

    private String size;

    PizzaSize(String size) {
        this.size = size;
    }


}
