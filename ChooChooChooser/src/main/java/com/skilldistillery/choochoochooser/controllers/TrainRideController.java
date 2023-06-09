package com.skilldistillery.choochoochooser.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.choochoochooser.data.TrainDAO;
import com.skilldistillery.choochoochooser.data.TrainRideDAO;
import com.skilldistillery.choochoochooser.data.UserDAO;
import com.skilldistillery.choochoochooser.entities.TrainRide;
import com.skilldistillery.choochoochooser.entities.User;
@Controller
public class TrainRideController {
	
		@Autowired
		private TrainRideDAO trainRideDAO;
		@Autowired
		private TrainDAO trainDAO;
		@Autowired
		private UserDAO userDAO;
		
		@RequestMapping(path="addToRides.do")
		public String addTrainRide(HttpSession session, TrainRide ride,@RequestParam("trainId") int trainId) {
			User userInSession = (User) session.getAttribute("loggedInUser");
			if (userInSession != null) {
				trainRideDAO.createTrainRide(userInSession, trainId, ride);
				refreshUserInSession(session);
			}	
			return "UserPage";
		}
		
		@RequestMapping(path="transferToRides.do")
		public String transferTrainRide(HttpSession session, TrainRide ride,@RequestParam("trainId") int trainId) {
			User userInSession = (User) session.getAttribute("loggedInUser");
			if (userInSession != null) {
				trainRideDAO.fromWishlistToRiddenList(userInSession, trainId, ride);
				refreshUserInSession(session);
			}	
			return "UserPage";
		}
		
		@RequestMapping(path="removeFromRiddenList.do")
		public String removeTrainFromRiddenlist(HttpSession session, @RequestParam("trainId") int trainId) {
			TrainRide trainRide = trainRideDAO.findRideById(trainId);
			User userInSession = (User) session.getAttribute("loggedInUser");
			if (userInSession != null) {
				User loggedInUser = userDAO.findByUsernameAndPassword(userInSession.getUsername(), userInSession.getPassword());
				trainRideDAO.removeFromRiddenList(loggedInUser, trainId, trainRide);
				refreshUserInSession(session);
				return "UserPage";
			}
			return "UserPage";
		}
		
		public void refreshUserInSession(HttpSession session) {
			User userInSession = (User) session.getAttribute("loggedInUser");
			User loggedInUser = userDAO.findByUsernameAndPassword(userInSession.getUsername(), userInSession.getPassword());
			session.setAttribute("loggedInUser", loggedInUser);
		}
		
}

