package com.emedinaa.kotlinapp.domain.model

import java.io.Serializable

data class Product( val objectId:String?,
                    val name:String?,
                    val description:String?,
                    val cost:Double?,
                    val logo:String?,
                    val code:String?): Serializable