<button type="button" class="btn btn-outline-success profile-update-button"
	data-bs-toggle='modal' data-bs-target='#updateUserModal'>Update
	Your Profile</button>


<div class="modal fade" id="updateUserModal" tabindex="-1"
	aria-labelledby="updateUserModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="updateUserModalLabel">Update
					Your Profile</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				
				<form action="updateUser.do" method="GET">
						<div class='col-12'>
							<span class='input-group-text'>User Name: </span> <input
								class='form-control' type="text" name="userName" value="${loggedInUser.username}"/>
						</div>
					<div class='col-12'>
						<span class='input-group-text'>Password: </span> <input
							class='form-control' name='password' type='password' value='${loggedInUser.password}'/>
					</div>
					<div class='col-12'>
						<span class='input-group-text'>First Name: </span> <input
							class='form-control' name='firstName' type='text' value='${loggedInUser.lastName}'/>
					</div>
					<div class='col-12'>
						<span class='input-group-text'>Last Name: </span> <input
							class='form-control' name='lastName' type='text' value='${loggedInUser.lastName}'/>
					</div>
						<div class='col-12'>
							<span class='input-group-text'>Upload A Profile Picture: </span> <input
								class='form-control' type='text' name='profilePhoto' value='${loggedInUser.profilePhoto}'/>
					</div>						
					<div class='col-12'>
						<span class='input-group-text'>Description : </span>
						<textarea class='form-control' rows='4' name='description' value='${loggedInUser.description}'></textarea>
					</div>
					<div class='col-12'>
						<c:choose>
							<c:when test="${loggedInUser.role == 'ADMIN'}">
								<input type='hidden' name='role' value='ADMIN'/>
							</c:when>
							<c:otherwise>
								<input type='hidden' name='role' value='USER'/>
							</c:otherwise>			
						</c:choose>					
					</div>
					<input type='submit' class='btn btn-success' name='Update User'>
					<input type='hidden' name='userId' value='${loggedInUser.id}' />
				</form>
			</div>
		</div>
	</div>
</div>