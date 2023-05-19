package com.skilldistillery.choochoochooser.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Engine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;

	public Engine() {
	}
	
	@OneToMany(mappedBy="engine")
	private List<Train> trains;

	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void addTrain(Train train) {
		if (trains == null) {
			trains = new ArrayList<>();
		}
		if (!trains.contains(train)) {
			trains.add(train);
			if (train.getEngine() != null) {
				train.getEngine().removeTrain(train);

			} else {
				train.setEngine(this);
			}
		}
	}

	public void removeTrain(Train train) {
		if (trains != null && trains.contains(train)) {
			trains.remove(train);
			train.setEngine(null);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Engine [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Engine other = (Engine) obj;
		return id == other.id;
	}
	
	
	
	

}
