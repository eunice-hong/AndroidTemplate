package com.eunicehong.template.core.ui.param.note

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.eunicehong.template.core.model.note.Note

/**
 * 방명록 미리보기 데이터를 제공합니다.
 */
internal class NoteParameterProvider : PreviewParameterProvider<Note> {
    override val values: Sequence<Note> =
        sequenceOf(
            // 짧은 이름과 짧은 내용
            Note(
                id = 1,
                userName = "하늘",
                content = "오늘은 기분이 좋아 보여요!",
                createdAt = System.currentTimeMillis(),
            ),
            // 긴 이름과 긴 내용
            Note(
                id = 2,
                userName = "김수한무 거북이와 두루미 삼천갑자 동방삭 치",
                content = "이 헌법시행 당시의 대법원장과 대법원판사가 아닌 법관은 제1항 단서의 규정에 불구하고 이 헌법에 의하여 임명된 것으로 본다.",
                createdAt = System.currentTimeMillis() - 1 * 24 * 60 * 60 * 1000L,
            ),
            // 짧은 이름과 긴 내용
            Note(
                id = 3,
                userName = "찬이",
                content =
                    "법원은 최고법원인 대법원과 각급법원으로 조직된다. 사법권은 법관으로 구성된 법원에 속한다. " +
                        "대통령은 내우·외환·천재·지변 또는 중대한 재정·경제상의 위기에 있어서 국가의 안전보장 또는 공공의 " +
                        "안녕질서를 유지하기 위하여 긴급한 조치가 필요하고 국회의 집회를 기다릴 여유가 없을 때에 한하여 최소한으로 " +
                        "필요한 재정·경제상의 처분을 하거나 이에 관하여 법률의 효력을 가지는 명령을 발할 수 있다.",
                createdAt = System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000L,
            ),
        )
}
