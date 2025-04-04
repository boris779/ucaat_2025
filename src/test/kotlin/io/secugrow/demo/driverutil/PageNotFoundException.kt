package io.secugrow.demo.driverutil

import logger

class PageNotFoundException(s: String) : Throwable() {

    private val log by logger()

    init {
        log.error(s)
    }


}
