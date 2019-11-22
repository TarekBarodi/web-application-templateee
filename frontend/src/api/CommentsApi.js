import Api from "./Api";

class CommentsApi {
    getAllComments() {
        return Api.get('/comments');
    }

    getCommentByPost(postId) {
        return Api.get('/comments',postId);
    }

    getCommentById(id) {
        return Api.get('/comments/'+id);
    }

    createComment(Comment) {
        return Api.post('/comments', Comment);
    }

    updateComment(Comment) {
        return Api.put('/comments', Comment);
    }

    deleteComment(id) {
        return Api.delete('/comments/'+id);
    }
}

export default new CommentsApi();