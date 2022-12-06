package com.sepatu.shooees.data.source.remote.response.product

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class Data(

	@field:SerializedName("per_page")
	val perPage: Int,

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("last_page")
	val lastPage: Int,

	@field:SerializedName("next_page_url")
	val nextPageUrl: String,

	@field:SerializedName("prev_page_url")
	val prevPageUrl: Any,

	@field:SerializedName("first_page_url")
	val firstPageUrl: String,

	@field:SerializedName("path")
	val path: String,

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("last_page_url")
	val lastPageUrl: String,

	@field:SerializedName("from")
	val from: Int,

	@field:SerializedName("links")
	val links: List<LinksItem>,

	@field:SerializedName("to")
	val to: Int,

	@field:SerializedName("current_page")
	val currentPage: Int
)

data class Category(

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("deleted_at")
	val deletedAt: Any
)

data class DataItem(

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("price")
	val price: String,

	@field:SerializedName("categories_id")
	val categoriesId: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("galleries")
	val galleries: List<GalleriesItem>,

	@field:SerializedName("category")
	val category: Category,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("tags")
	val tags: Any
)

data class LinksItem(

	@field:SerializedName("active")
	val active: Boolean,

	@field:SerializedName("label")
	val label: String,

	@field:SerializedName("url")
	val url: Any
)

data class GalleriesItem(

	@field:SerializedName("products_id")
	val productsId: Int,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("url")
	val url: String
)
