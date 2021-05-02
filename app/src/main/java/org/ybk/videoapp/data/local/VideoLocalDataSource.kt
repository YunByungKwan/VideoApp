package org.ybk.videoapp.data.local

import org.ybk.videoapp.data.dto.Video
import org.ybk.videoapp.util.Constants

class VideoLocalDataSource: LocalDataSource {
    private val videoList = listOf(
        Video(0, "[놀면 뭐하니? 후공개] SG워너비 노래 모음 (Hangout with Yoo - MSG Wannabe YooYaHo)", "놀면 뭐하니?", Constants.url,
                3879663, 55901, 1003, "2021-04-27", "2021-04-27"),
        Video(1, "벌써 하루 남은 원천상회 사장직...아쉬운 맘이 드는 인성ㅠㅜ#어쩌다사장\u200B | Unexpected Business EP.10 | tvN 210429 방송", "tvN", Constants.url,
            416, 54, 0, "2021-04-27", "2021-04-27"),
        Video(2, "철이 없었죠… 젬베가 좋아서 아프리카에 유학을 갔다는 자체가", "크림히어로즈", Constants.url,
            43732, 4356, 13, "2021-04-27", "2021-04-27"),
        Video(3, "취준 한잔 할래요☕ 국내 프랜차이즈 1위 이디야 다녀옴 | 이디야 | 카페 | 기업탐방 ep.13", "워크맨-Workman", Constants.url,
            768361, 9639, 192, "2021-04-27", "2021-04-27"),
        Video(4, "나처럼 게임 잘하고싶어?", "릴카", Constants.url,
            18271, 205, 3, "2021-04-27", "2021-04-27"),
        Video(5, "고양이가 장난감을 만났을때", "크림히어로즈", Constants.url,
            106655, 0, 0, "2021-04-27", "2021-04-27"),
        Video(6, "요리하는 남자가 지인의 가게에 놀러가면 벌어지는 일", "취미로 요리하는 남자 Yonam", Constants.url,
            1000, 3006, 32, "2021-04-27", "2021-04-27"),
        Video(7, "[복면가왕] 음색 요정 가수 펀치의 드라마 OST 메들리~♬, MBC 210207 방송", "MBCentertainment", Constants.url,
            633328, 5888, 52, "2021-04-27", "2021-04-27"))

    override fun getVideoList(): List<Video> {
        return videoList
    }

    override fun getVideo(id: Long): Video {
        for(video in videoList) {
            if(video.id == id) {
                return video
                break
            }
        }
        return Video(0,"","","",0,
                0,0,"","")
    }
}