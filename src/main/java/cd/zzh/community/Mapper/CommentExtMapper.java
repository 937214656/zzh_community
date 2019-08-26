package cd.zzh.community.Mapper;

import cd.zzh.community.model.Comment;
import cd.zzh.community.model.CommentExample;
import cd.zzh.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}