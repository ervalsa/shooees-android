package com.sepatu.shooees.utils

import com.sepatu.shooees.R
import com.sepatu.shooees.data.entity.ProductEntity

object DataDummy {

    fun generateDataProduct(): List<ProductEntity> {
        val listProduct = ArrayList<ProductEntity>()

        listProduct.add(
            ProductEntity(
                1,
                "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium//102/MTA-52995513/adidas_sepatu_adidas_nmd_r1_gx6978_full02_tfe0fi16.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                2,
                "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium//102/MTA-52995513/adidas_sepatu_adidas_nmd_r1_gx6978_full02_tfe0fi16.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                3,
                "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium//102/MTA-52995513/adidas_sepatu_adidas_nmd_r1_gx6978_full02_tfe0fi16.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                4,
                "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium//102/MTA-52995513/adidas_sepatu_adidas_nmd_r1_gx6978_full02_tfe0fi16.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                5,
                "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium//102/MTA-52995513/adidas_sepatu_adidas_nmd_r1_gx6978_full02_tfe0fi16.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                6,
                "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium//102/MTA-52995513/adidas_sepatu_adidas_nmd_r1_gx6978_full02_tfe0fi16.jpg",
                "NMD R1",
                4000000,
                "Dunno wat tu do",
                "Running",
            )
        )

        return listProduct
    }
}