package com.sepatu.shooees.utils

import com.sepatu.shooees.data.entity.ProductEntity

object DataDummy {

    fun generateDataProduct(): List<ProductEntity> {
        val listProduct = ArrayList<ProductEntity>()

        listProduct.add(
            ProductEntity(
                1,
                "https://www.adidas.co.id/media/catalog/product/g/z/gz7997_sl_ecom.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                2,
                "https://www.adidas.co.id/media/catalog/product/g/z/gz7997_sl_ecom.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                3,
                "https://www.adidas.co.id/media/catalog/product/g/z/gz7997_sl_ecom.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                4,
                "https://www.adidas.co.id/media/catalog/product/g/z/gz7997_sl_ecom.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                5,
                "https://www.adidas.co.id/media/catalog/product/g/z/gz7997_sl_ecom.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                6,
                "https://www.adidas.co.id/media/catalog/product/g/z/gz7997_sl_ecom.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        return listProduct
    }
}