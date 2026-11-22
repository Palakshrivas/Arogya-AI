package backend.backend.mapper;

import backend.backend.dto.QuestionResponse;
import backend.backend.entity.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {

    public QuestionResponse toResponse(Question question) {
        if (question == null) {
            return null;
        }

        return new QuestionResponse(
                question.getId(),
                question.getQuestionText(),
                question.getOptionA(),
                question.getOptionB(),
                question.getOptionC(),
                question.getOptionD(),
                question.getCorrectAnswer(),
                question.getExplanation(),
                question.getExam(),
                question.getDifficulty(),
                question.getTopic(),
                question.getSubject() != null
                        ? question.getSubject().getId()
                        : null,
                question.getSubject() != null
                        ? question.getSubject().getName()
                        : null,
                question.getChapter() != null
                        ? question.getChapter().getId()
                        : null,
                question.getChapter() != null
                        ? question.getChapter().getName()
                        : null
        );
    }
}
