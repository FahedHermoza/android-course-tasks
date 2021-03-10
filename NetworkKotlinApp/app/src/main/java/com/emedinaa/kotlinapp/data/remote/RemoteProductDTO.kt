package com.emedinaa.kotlinapp.storage.remote

import com.google.gson.annotations.SerializedName


/**
 * @author Eduardo Medina
 */

//User
data class UserDTO(
    @SerializedName("user-token") val token:String?, val email:String?,
    val objectId:String?
)


data class LogInRaw(val login:String?,val password:String?)

data class LogInResponse(@SerializedName("user-token") val token:String?, val email:String?,
                         val objectId:String?)

//Note
data class NoteRaw(
    val title:String?, val description:String?
)

//@SerializedName("name")
data class NoteDTO(
    val objectId:String?,val title:String?,val message:String?,val code:String?,
    val description:String?
)

open class BaseResponse(private val status: Int?, val msg: String?) {
    companion object {
        const val STATUS_CODE: Int = 200
    }

    protected fun isSuccess(): Boolean {
        return status == STATUS_CODE
    }
}

class NoteResponse(val objectId:String?,val title:String?,val message:String?,val code:String?,
                   val description:String?)