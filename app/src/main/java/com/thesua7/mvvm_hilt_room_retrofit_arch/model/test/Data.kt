package com.thesua7.mvvm_hilt_room_retrofit_arch.model.test

data class Data(
    val access_token: String,
    val api_token: String,
    val avatar: String,
    val certificates: List<Certificate>,
    val created_at: String,
    val deleted_at: String,
    val designation: String,
    val details: Details,
    val dp: String,
    val educations: List<Education>,
    val email: String,
    val email_verified_at: String,
    val experiences: List<Experience>,
    val first_name: String,
    val id: Int,
    val last_grad_date: String,
    val last_name: String,
    val location: String,

    val occupation_id: Int,
    val phone: String,
    val provider: String,
    val provider_id: String,
    val qas: List<Qa>,
    val studying: Int,
    val updated_at: String
)