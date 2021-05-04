import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTollCalculator {

	TollCalculator cal;

	@Before
	public void begin() throws Exception {
		cal = new TollCalculator();
	}

	@Test
	public void testCostOfTrip1(){
		Trip t = cal.costOfTrip("QEW", "Highway 400");
		Assert.assertEquals("Distance expected", 67.748, t.distance, 0.0001);
	}

	@Test(expected = LocationNotFoundException.class)
	public void testCostOfTripException1(){
		Trip t = cal.costOfTrip("A", "Highway 400");
		Assert.assertEquals("Distance expected", 67.748, t.distance, 0.0001);
	}

	@Test(expected = LocationNotFoundException.class)
	public void testCostOfTripException2(){
		Trip t = cal.costOfTrip("QEW", "B");
		Assert.assertEquals("Distance expected", 67.748, t.distance, 0.0001);
	}

	@Test
	public void testCostOfTripDistanceZero(){
		Trip t = cal.costOfTrip("QEW", "QEW");
		Assert.assertEquals("Distance expected", 0, t.distance, 0.0001);
	}

	@Test
	public void testCostOfTripNoRoute(){
		Trip t = cal.costOfTrip("Salem Road", "QEW");
		Assert.assertEquals("Distance expected", 0, t.distance, 0.0001);
	}

	@Test
	public void testCostOfTrip2(){
		Trip t = cal.costOfTrip("QEW", "Salem Road");
		Assert.assertEquals("Distance expected", 115.277, t.distance, 0.0001);
	}

	@Test
	public void testCostOfTrip3(){
		Trip t = cal.costOfTrip("QEW", "Dundas Street");
		Assert.assertEquals("Distance expected", 6.062, t.distance, 0.0001);
	}
}
