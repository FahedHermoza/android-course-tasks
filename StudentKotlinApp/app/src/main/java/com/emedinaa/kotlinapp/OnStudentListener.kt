package com.emedinaa.kotlinapp

import com.emedinaa.kotlinapp.model.Student

/**
 * @author Eduardo Medina
 */
interface OnStudentListener {

    fun selectedItemProduct(student: Student)
    fun renderFirst(student: Student?)
}