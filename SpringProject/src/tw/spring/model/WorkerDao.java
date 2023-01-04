package tw.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("wDao")
public class WorkerDao {
	
//	@Autowired @Qualifier("worker1")
	private Worker worker;
	
	public WorkerDao() {
	}
	
	@Autowired
	public WorkerDao(@Qualifier("worker2") Worker worker) {
		this.worker = worker;
	}
	
	public void printDetails() {
		System.out.println(worker.getId() + " " + worker.getName() + " " + worker.getTitle());
	}
}
