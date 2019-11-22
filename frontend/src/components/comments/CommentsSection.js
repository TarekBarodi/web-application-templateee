import React from "react";
import CommentsApi from "./../../api/CommentsApi";
import CommentForm from "./CommentForm";
import CommentCard from "./CommentCard";

class CommentsSection extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      comments: []
    };
  }

  async createComment(commentData) {
    try {
      const response = await CommentsApi.createComment(
        commentData,
        this.props.post
      );
      const comment = response.data;
      const newComments = this.state.comments.concat(comment);

      this.setState({
        comments: newComments
      });
    } catch (e) {
      console.error(e);
    }
  }

  async deleteComment(comment) {
    try {
      await CommentsApi.deleteComment(comment.id);
      const newComments = this.state.comments.filter(p => p.id !== comment.id);
      this.setState({
        comments: newComments
      });
    } catch (e) {
      console.error(e);
    }
  }

  componentDidMount() {
    CommentsApi.getCommentByPost(this.props.post.id)
      .then(({ data }) => this.setState({ comments: data }))
      .catch(err => console.error(err));
  }

  render() {
    const comments = this.state.comments;

    return (
      <div>
        {comments.map(comment => (
          <CommentCard
            key={comment.id}
            comment={comment}
            onDeleteClick={() => this.deleteComment(comment)}
          />
        ))}

        <CommentForm
          post={this.props.post}
          onSubmit={commentData => this.createComment(commentData)}
        />
      </div>
    );
  }
}

export default CommentsSection;
