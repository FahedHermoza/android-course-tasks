package com.emedinaa.kotlinapp.model

import com.emedinaa.kotlinapp.R


object Data {
        fun getStudent() = listOf(
                Student(
                        1,
                        "Fahed Hermoza",
                        "54911231245",
                        "admin@gmail.com",
                        "www.fahedhermoza.dev",
                        R.mipmap.ic_student
                ),
                Student(
                        2,
                        "Paulo Londra",
                        "54911231245",
                        "admin@gmail.com",
                        "www.paulolondra.dev",
                        R.mipmap.ic_student
                ),
                Student(
                        3,
                        "Jaze",
                        "54911231245",
                        "admin@gmail.com",
                        "www.jaze.dev",
                        R.mipmap.ic_student
                ),
                Student(
                        4,
                        "Neckros",
                        "54911231245",
                        "admin@gmail.com",
                        "www.neckros.dev",
                        R.mipmap.ic_student
                ),
                Student(
                        5,
                        "J Choy",
                        "54911231245",
                        "admin@gmail.com",
                        "www.jchoy.dev",
                        R.mipmap.ic_student
                ),
                Student(
                        6,
                        "Skill",
                        "54911231245",
                        "admin@gmail.com",
                        "www.skill.dev",
                        R.mipmap.ic_student
                )

        )

}
data class Student(var id:Int, var name:String, var phone: String, var email:String,var webSite:String, var photo: Int)