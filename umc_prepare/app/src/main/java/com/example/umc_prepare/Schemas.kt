package com.example.umc_prepare


import com.squareup.moshi.Json

data class Schemas(
    @Json(name = "ChatRequest")
    val chatRequest: ChatRequest?,
    @Json(name = "ChatResponse")
    val chatResponse: ChatResponse?,
    @Json(name = "CreateArticlePhotosReq")
    val createArticlePhotosReq: CreateArticlePhotosReq?,
    @Json(name = "CreateArticleReq")
    val createArticleReq: CreateArticleReq?,
    @Json(name = "DetailArticlePhotoRes")
    val detailArticlePhotoRes: DetailArticlePhotoRes?,
    @Json(name = "DetailArticleRes")
    val detailArticleRes: DetailArticleRes?,
    @Json(name = "GptResponse")
    val gptResponse: GptResponse?,
    @Json(name = "IndustryKeyword")
    val industryKeyword: IndustryKeyword?,
    @Json(name = "LoginMember")
    val loginMember: LoginMember?,
    @Json(name = "MemberResponse")
    val memberResponse: MemberResponse?,
    @Json(name = "PageSearchArticleRes")
    val pageSearchArticleRes: PageSearchArticleRes?,
    @Json(name = "Pageable")
    val pageable: PageableX?,
    @Json(name = "PageableObject")
    val pageableObject: PageableObject?,
    @Json(name = "QuestionRequest")
    val questionRequest: QuestionRequest?,
    @Json(name = "ResponseCustomChatResponse")
    val responseCustomChatResponse: ResponseCustomChatResponse?,
    @Json(name = "ResponseCustomDetailArticleRes")
    val responseCustomDetailArticleRes: ResponseCustomDetailArticleRes?,
    @Json(name = "ResponseCustomGptResponse")
    val responseCustomGptResponse: ResponseCustomGptResponse?,
    @Json(name = "ResponseCustomLong")
    val responseCustomLong: ResponseCustomLong?,
    @Json(name = "ResponseCustomPageSearchArticleRes")
    val responseCustomPageSearchArticleRes: ResponseCustomPageSearchArticleRes?,
    @Json(name = "ResponseCustomVoid")
    val responseCustomVoid: ResponseCustomVoid?,
    @Json(name = "SearchArticleRes")
    val searchArticleRes: SearchArticleRes?,
    @Json(name = "SignUpRequest")
    val signUpRequest: SignUpRequest?,
    @Json(name = "SortObject")
    val sortObject: SortObject?
)