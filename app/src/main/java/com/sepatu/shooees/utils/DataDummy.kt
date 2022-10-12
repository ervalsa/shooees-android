package com.sepatu.shooees.utils

import com.sepatu.shooees.R
import com.sepatu.shooees.data.entity.CartEntity
import com.sepatu.shooees.data.entity.ProductEntity

object DataDummy {

    fun generateDataProduct(): List<ProductEntity> {
        val listProduct = ArrayList<ProductEntity>()

        listProduct.add(
            ProductEntity(
                1,
                "https://www.adidas.co.id/media/catalog/product/cache/3bec5fdb79d91223b1a151be2b21ce8d/g/w/gw3903_sl_ecom.jpg",
                "Adidas Dropset Trainer",
                2200000,
                "Taklukkan sesi latihan kekuatan dan olahraga di gym tanpa ragu. Sepatu adidas ini membantumu meningkatkan level permainan. Midsole dropset memberikan sensasi kontak darat untuk menunjang postur tubuh yang tepat dan meningkatkan kepercayaan diri dalam gerakanmu.",
                "Training",
            )
        )

        listProduct.add(
            ProductEntity(
                2,
                "https://www.adidas.co.id/media/catalog/product/cache/3bec5fdb79d91223b1a151be2b21ce8d/E/G/EG2656_SL_eCom.jpg",
                "Adidas Strutter",
                900000,
                "Menghadirkan kesan paling kental dari dad shoes, sepatu ini memiliki desain chunky yang membuat Anda tetap nyaman sepanjang hari. Upper dari bahan kulit lembut dihiasi dengan detail cutout, overlay, dan 3-Stripes yang khas. Dilengkapi dengan sculpted midsole high-profile dan outsole berdaya cengkeram kuat.",
                "Training",
            )
        )

        listProduct.add(
            ProductEntity(
                3,
                "https://www.adidas.co.id/media/catalog/product/cache/3bec5fdb79d91223b1a151be2b21ce8d/e/g/eg2658_sl_ecom.jpg",
                "Adidas Reguera",
                9000000,
                "Rasakan kekuatan tren fitness di era 80-an. Sepatu ini menghadirkan sepatu klasik dengan model yang lebih modern, serta nyaman dan stylish untuk aktivitas sepanjang hari. Dilengkapi upper dari material kulit yang dilapisi dan midsole twin-cup ikonik untuk memberikan pantulan maksimal dalam langkah Anda.",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                4,
                "https://www.adidas.co.id/media/catalog/product/cache/3bec5fdb79d91223b1a151be2b21ce8d/h/q/hq1078_sl_ecom.jpg",
                "Adidas SL20.3 BP2",
                1900000,
                "Connect with your inner superhero. These running shoes are part of the adidas x Marvel Black Panther collaboration. These race-ready shoes handle demanding intervals, long distances and friendly 5Ks. The light and breathable upper helps you stay cool through speedy laps on warm days, and the Lightstrike EVA + Lightstrike Pro midsole delivers a light and quick feel.",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                5,
                "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/0e7455dd-c1e4-4148-b4c7-9897304f0508/zoomx-invincible-run-flyknit-2-road-running-shoes-xrCMmF.png",
                "Nike Zoom X",
                2849000,
                "Keep pushing your runs to the limit. The Nike ZoomX Invincible Run Flyknit 2 keeps you going with the same super-soft feel that lets you feel the potential when your foot hits the pavement.",
                "Running",
            )
        )

        listProduct.add(
            ProductEntity(
                6,
                "https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/2bcca083-9fcd-4362-8af8-f36053b690e4/air-wio-9-road-running-shoes-185Kr9.png",
                "Nike Air Winflo 9",
                1449000,
                "Fast enough for your everyday runs, light enough to keep you in the flow. The Nike Air Winflo 9 has a secure fit that keeps your foot in place as the miles go by. We added plenty of foam through the midsole, giving you extra pep to every step. Lace up, lock in, win your goals.",
                "Running",
            )
        )

        return listProduct
    }

    fun generateDataCart(): List<CartEntity> {
        val listCart = ArrayList<CartEntity>()

        listCart.add(
            CartEntity(
                1,
                "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/20477ebc-c447-44d7-98bc-eb3523cc933f/phantom-gt2-elite-fg-football-boot-wRNH0g.png",
                "Nike Phantom GT2 Elite FG",
                3559000,
                "Building off the Phantom GT, the Nike Phantom GT2 Elite FG features an updated design and raised patterning to help create optimal spin to control the flight of the ball. Off-centre lacing provides a clean strike zone for skilful dribbling, passing and shooting.",
                "Football",
            )
        )

        listCart.add(
            CartEntity(
                2,
                "https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/8acc0cdb-55ad-4cf3-a4ca-cbc57e40c096/tiempo-legend-9-academy-tf-football-shoe-FT9Mcp.png",
                "Nike Tiempo Legend 9 Academy TF",
                999000,
                "1 of our lightest Tiempos to date, the Nike Tiempo Legend 9 Academy TF lets you go on the offensive with a low-profile design that's reinvented for attackers. The upper features raised areas throughout the strike zone for precise dribbling, passing and shooting, while a rubber sole helps supercharge traction on turf.",
                "Football",
            )
        )

        return listCart
    }
}