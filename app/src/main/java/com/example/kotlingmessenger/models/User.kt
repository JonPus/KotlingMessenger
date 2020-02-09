package com.example.kotlingmessenger.models

class User(val uid: String, val username: String, val profileImageUrl: String){
    constructor() : this("", "","")
}