<button type="button" class="btn btn-outline-success"
	data-bs-toggle='modal' data-bs-target='#TrainCommentModal'>Leave A Comment</button>


<div class="modal fade" id="TrainCommentModal" tabindex="-1"
	aria-labelledby="TrainCommentModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="TrainCommentModalLabel">Leave A Comment
					</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="addComment.do" method="GET">
					<div class='col-12'>
						<span class='input-group-text'>Leave A Comment! </span>
						<textarea class='form-control' rows='4' name='comment'></textarea>
						
						<input type='hidden' name='enabled' value='1'/>
						<input type='hidden' name='trainId' value='${train.id}' /> 
						<input type='hidden' name='userId' value='${loggedInUser.id}' /> 
							<input type='submit' class='btn btn-success' name='Add Comment'/>
					</div>
				</form>
			</div>


			</div>
		</div>

</div>