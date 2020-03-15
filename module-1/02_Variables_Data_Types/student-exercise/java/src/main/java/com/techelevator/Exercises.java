package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */

        int numberOfRaccoons = 3;
        int raccoonsThatLeft = 2;
        int remainingRaccoons = numberOfRaccoons - raccoonsThatLeft;

            System.out.println("There are " + remainingRaccoons + " left in the woods.");

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */

        int numberOfFlowers = 5;
        int numberOfBees = 3;
        int difference = numberOfFlowers - numberOfBees;

            System.out.println("There are " + difference + " less bees than flowers.");

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */

        int lonelyPigeon = 1;
        int anotherPigeon = 1;
        int totalPigeons = lonelyPigeon + anotherPigeon;

            System.out.println(totalPigeons + " are eating breadcrumbs.");

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */

        int initialOwls = 3;
        int joiningOwls = 2;
        int totalOwls = initialOwls + joiningOwls;

            System.out.println(totalOwls + " are on the fence.");


        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

        int workingBeavers = 2;
        int swimmingBeavers = 1;
        int stillWorking = workingBeavers - swimmingBeavers;

            System.out.println(stillWorking + " are still working on their home.");

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

        int sittingToucans = 2;
        int joiningToucans = 1;
        int totalToucans = sittingToucans + joiningToucans;

            System.out.println(totalToucans + " are sitting in all.");

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */

        int squirrelsInTree = 4;
        int nutsInTree = 2;
        int squirrelDifference = squirrelsInTree - nutsInTree;

            System.out.println("There are " + squirrelDifference + " more squirrels than nuts.");

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */

        float quarter = .25f;
        float dime = .10f;
        float nickel = .05f;

        float totalMoney = quarter + dime + nickel + nickel;

            System.out.println("Mrs. Hilt fount " + totalMoney + " cents.");



        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

        int brierMuffins = 18;
        int macadamsMuffins = 20;
        int flanneryMuffins = 17;

        int firstGradeTotalMuffins = brierMuffins + macadamsMuffins + flanneryMuffins;

            System.out.println("First grade baked " + firstGradeTotalMuffins + " muffins.");

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

        float yoyoPrice = .24f;
        float whistlePrice = .14f;
        float totalPrice = yoyoPrice + whistlePrice;

            System.out.println("Total spent was " + "$" + totalPrice);


        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

        int largeMarshmallow = 8;
        int miniMarshmallow = 13;
        int totalMarshmallow = largeMarshmallow + miniMarshmallow;

            System.out.println("Total marshmallows used were " + totalMarshmallow);

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */

        int hiltHouseSnow = 29;
        int brecknockSchoolSnow = 17;
        int snowDifference = hiltHouseSnow - brecknockSchoolSnow;

            System.out.println("Mrs. Hilt's house had " + snowDifference + " inches more snow");

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */

        int shoppingBudget = 10;
        int truckPrice = 3;
        int pencilCasePrice = 2;
        int remainingBudget = shoppingBudget - truckPrice - pencilCasePrice;

            System.out.println("Money remaining is " + "$" + remainingBudget);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

        int totalMarbles = 16;
        int lostMarbles = 7;
        totalMarbles = totalMarbles - lostMarbles;

            System.out.println("Josh now has " + totalMarbles + " marbles.");

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */

        int desiredTotal = 25;
        int currentTotal = 19;
        int seashellsNeeded = desiredTotal - currentTotal;

            System.out.println("Megan needs " + seashellsNeeded + " seashells.");

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

        int totalBalloons = 17;
        int redBalloons = 8;
        int greenBalloons = totalBalloons - redBalloons;

            System.out.println("Brad has " + greenBalloons + " green balloons.");

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

        int currentBooks = 38;
        currentBooks+= 10;

            System.out.println(currentBooks + " books are on the shelf.");


        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */

        int legsOnBee = 6;
        int legsOnEightBees = legsOnBee * 8;

            System.out.println("8 bees have " + legsOnEightBees + " legs");

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

        float coneCost = .99f;
        float twoConeCost = coneCost * 2;

            System.out.println("2 ice cream cones cost " + twoConeCost);

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */

        int desiredRockTotal = 125;
        int currentRocks = 64;
        int rocksNeeded = desiredRockTotal - currentRocks;
            System.out.println("Mrs. Hilt needs " + rocksNeeded + " more rocks.");

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

        int hiltMarbles = 38;
        int marblesLost = 15;
        hiltMarbles-= marblesLost;
            System.out.println("Mrs. Hilt has " + hiltMarbles + " marbles left.");



        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

        int destinationMilesAway = 78;
        int milesDriven = 32;
        int milesRemaining = destinationMilesAway - milesDriven;
            System.out.println(milesRemaining + " miles left to drive.");

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
        float morningShovelTime = 1.5f;
        float afternoonShovelTime = .75f;
        float totalShovelTime = morningShovelTime + afternoonShovelTime;
            System.out.println("Total time spent shoveling: " + totalShovelTime + " minutes");


        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */

        int totalHotDogs = 6;
        float hotDogPrice = .50f;
        float totalCost = totalHotDogs * hotDogPrice;
            System.out.println("Mrs. Hilt paid a total of $" + totalCost + " for hot dogs.");

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */

        float pencilBudget = .50f;
        float pricePerPencil = .07f;
        float availablePencils = pencilBudget / pricePerPencil;

            System.out.println("Mrs. Hilt can buy " + availablePencils + " pencils.");


        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */

        int totalButterflies = 33;
        int orangeButterflies = 20;
        int redButterflies = totalButterflies = orangeButterflies;

            System.out.println(redButterflies + " butterflies were red.");

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

        float paidMoney = 1.0f;
        float candyCost = .54f;
        float change = paidMoney - candyCost;

            System.out.println("Kate should get back " + change + " in change.");

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */

        int currentTrees = 13;
        int plantedTrees = 12;
        currentTrees += plantedTrees;

            System.out.println("Mark will have " + currentTrees + " trees.");

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */

        int hoursPerDay = 24;
        int daysLeft = 2;
        int remainingHours = hoursPerDay * daysLeft;

            System.out.println("Joy will see her grandma in " + remainingHours + " hours");

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */

        int totalCousins = 4;
        int gumPerCousin = 5;
        int totalGumNeeded = totalCousins * gumPerCousin;

            System.out.println("Kim will need " + totalGumNeeded + " pieces of gum.");

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */

        float candyBudget = 3.0f;
        float candyPurchased = 1.0f;
        float candyBudgetRemaining = candyBudget - candyPurchased;
            System.out.println("Dan has $" + candyBudgetRemaining + " left");

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

        int totalBoats = 5;
        int peoplePerBoat = 3;
        int totalPeople = totalBoats * peoplePerBoat;
            System.out.println(totalPeople + " are in boats");

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

        int totalLegos = 380;
        int lostLegos = 57;
        totalLegos-= lostLegos;
            System.out.println("Ellen has " + totalLegos + " legos.");

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */

        int desiredMuffins = 83;
        int bakedMuffins = 35;
        int muffinsNeeded = desiredMuffins - bakedMuffins;
            System.out.println("Arthur needs to bake " + muffinsNeeded + " muffins.");

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

        int willyCrayons = 1400;
        int lucyCrayons = 290;
        int crayonDifference = willyCrayons = lucyCrayons;
            System.out.println("Willy has " + crayonDifference + " more crayons than Lucy.");


        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

        int stickersPerPage = 10;
        int totalPages = 22;
        int totalStickers = stickersPerPage * totalPages;
            System.out.println("You have " + totalStickers + " stickers");

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */

        int totalCupcakes = 96;
        int totalChildren = 8;
        int servingPerChild = totalCupcakes / totalChildren;
            System.out.println("Each person will get " + servingPerChild + " cupcakes");

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */

        int totalCookies = 47;
        int cookiesPerJar = 6;
        int extraCookies = totalCookies % cookiesPerJar;
            System.out.println(extraCookies + " cookies will not be placed in a jar.");

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */

        int totalCroissants = 59;
        int totalNeighbors = 8;
        int extraCroissants = totalCroissants % totalNeighbors;
            System.out.println(extraCroissants + " will be left with Marian.");

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */

        int cookiesNeeded = 276;
        int cookiesPerTray = 12;
        int traysNeeded = cookiesNeeded / cookiesPerTray;
            System.out.println("Marian will need " + traysNeeded + " trays");

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */

        int totalPretzels = 480;
        int singleServing = 12;
        int preparedServings = totalPretzels / singleServing;
            System.out.println("Marian prepared " + preparedServings + " servings of pretzels");

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

        int totalLemonCupcakes = 53;
        int cakesLeftHome = 2;
        int cakesPerBox = 3;

        int boxesGivenAway = (totalLemonCupcakes - cakesLeftHome) / cakesPerBox;
            System.out.println(boxesGivenAway + " boxes of cupcakes were given away");

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */

        int totalCarrotSticks = 74;
        int peopleServed = 12;
        int remainingCarrotSticks = totalCarrotSticks % peopleServed;
            System.out.println(remainingCarrotSticks + " carrots were left uneaten");

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

        int totalBears = 98;
        int bearsPerShelf = 7;
        int filledShelves = totalBears / bearsPerShelf;
            System.out.println(filledShelves + " shelves will be filled");

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */

        int picturesPerAlbum = 20;
        int totalPictures = 480;
        int albumsNeeded = totalPictures / picturesPerAlbum;
            System.out.println("Susie's mother will need " + albumsNeeded + " albums");

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */

        int collectedCards = 94;
        int cardsPerFullBox = 8;
        int filledBoxes = collectedCards / cardsPerFullBox;
        int cardsNotInBox = collectedCards % cardsPerFullBox;

            System.out.println("There are " + cardsNotInBox + " cards in the unfilled box");



        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

        int totalBooks = 210;
        int totalShelves = 10;
        int booksPerShelf = totalBooks / totalShelves;
            System.out.println("Each shelf will contain " + booksPerShelf + " books");


        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

        int bakedCroissants = 17;
        int totalGuests = 7;
        int croissantsPerGuest = bakedCroissants / totalGuests;
            System.out.println("Each guest will have " + croissantsPerGuest + " croissants");


        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in
        feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */

        int totalFeetInRoom = 12 * 14;
        float billHours = 2.15f;
        float jillHours = 1.90f;
        float billFeetPerHour = totalFeetInRoom / billHours;
        float jillFeetPerHour = totalFeetInRoom / jillHours;
        float totalFeetPerHour = billFeetPerHour + jillFeetPerHour;
        float grandTotalFeet = totalFeetInRoom * 5;
            //How long will it take the two painter working together to paint 5 12 x 14 rooms?
        float combinedTotalTime = grandTotalFeet / totalFeetPerHour;
            System.out.println("The painters will take " + combinedTotalTime + " hours to paint 5 rooms");

           // Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        float totalFeetPerDay = (billFeetPerHour * 8) + (jillFeetPerHour * 8);
        int totalFeet = totalFeetInRoom * 623;
        float totalDays = totalFeet / totalFeetPerDay;
            System.out.println("It will take " + totalDays + " days to paint 623 rooms");




        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

        String firstName = "Meredith";
        String lastName = "Silvernail";
        String middleInitial = "L";

        String fullName = lastName + ", " + firstName + " " + middleInitial + ".";
            System.out.println(fullName);

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */

        float totalMiles = 800;
        float distanceTravelled = 537;
        float percentCompleted = (int)((distanceTravelled / totalMiles) * 100);
            System.out.println(percentCompleted);


	}

}
