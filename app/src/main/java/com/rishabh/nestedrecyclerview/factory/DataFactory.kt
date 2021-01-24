package com.rishabh.nestedrecyclerview.factory

import com.rishabh.nestedrecyclerview.dtos.ChildDTO
import com.rishabh.nestedrecyclerview.dtos.ParentDTO
import kotlin.random.Random

object DataFactory {

    // to generate random numbers
    private val rand = Random(123123123L)

    // Sample titles
    private val titles = listOf("Vertigo",
        "The Innocents",
        "Lawrence of Arabia",
        "The Deer Hunter",
        "Amadeus",
        "Blade Runner",
        "Eyes Wide Shut"
    )

    // Sample descriptions
    private val descriptions = listOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "Pellentesque sagittis odio ut tincidunt scelerisque.",
        "Phasellus a neque consequat leo bibendum tempus.",
        "Quisque at enim id odio blandit imperdiet nec consequat augue.",
        "Cras iaculis lorem a dignissim egestas.",
        "Duis quis leo pharetra, vestibulum elit rhoncus, tempus ante.",
        "Duis ut lorem aliquet, lobortis massa a, fringilla velit.",
        "Fusce non ipsum sed augue gravida ullamcorper."
    )

    // Returns a sample `ParentDTO` Object
    fun getParentList(): List<ParentDTO> {
        val list = ArrayList<ParentDTO>()
        for (i in 1..rand.nextInt(5, 10)) {
            list.add(ParentDTO(
                titles[rand.nextInt(titles.size)], descriptions[rand.nextInt(descriptions.size)], getChildList()
            ))
        }
        return list
    }

    // Returns a sample `List<ChildDTO>` Object to populate the parent object
    private fun getChildList(): List<ChildDTO> {
        val list = ArrayList<ChildDTO>()
        for (i in 1..rand.nextInt(5, 10)) {
            list.add(getRandomChild())
        }
        return list
    }

    // Returns a sample `ChildDTO` Object
    private fun getRandomChild(): ChildDTO {
        return ChildDTO(
            titles[rand.nextInt(titles.size)],
            descriptions[rand.nextInt(descriptions.size)],
            "@mipmap/img_sample"
        )
    }
}