package com.gapache.commons.helper;

public final class AccessCardHeaderHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new InheritableThreadLocal<>();

    public static String getHeader() {
        return CONTEXT_HOLDER.get();
    }

    public static void setHeader(String header) {
        CONTEXT_HOLDER.set(header);
    }

    public static void clear() {
        CONTEXT_HOLDER.remove();
    }
}
