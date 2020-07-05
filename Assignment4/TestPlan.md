# Test Plan

**Author**: Team 91

**Version**: 1.0

## 1 Testing Strategy

### 1.1 Overall strategy

- Analyze the final product
- Establish and create test objectives
- Design criteria: correctness, feasibility, coverage, functionality
- Define scope of Testing
- Develop test cases
- Check test cases
- Execute test cases
- Document Issues & Risks
- Create and Evaluate test logistics

Install/Uninstall Testing
- Find out and make sure user device satisfy minimum hardware/software requriements to perform an install.
- Purpose: Focus on user story on what the actual user will need to do to install/uninstall the application successfully.

Unit Testing
- Test the smallest component of extratable software from the application
- Purpose: validate that each component of the intented software performs as expected

Integration Testing
- Building block components will be combined into functional clusters and tested accordingly
- Purpose: Have MainActivity.java act as a driver for the clusters of components and test them as they are being designed, integrated, and developed

Regression Testing
- Tests will include but not be limited to a set of partial selection of already run testing suites which shall be execcuted and rexicuted to make sure existing functionalites of the application stay intact.
- Test Prioritization: depending on the buisness impact, and freqent functionalities, some test cases will be prioritized and some will not

System Testing
- Security testing: can CurrentJobOffer or JobOffers information be illegally modified (Short answer: no)
- Recovery testing: Verifies the system's ability to recover after certain points of failure triggered by the test case
- Performance testing: test user input selections and acess the speed and response of the overall GUI of the application
- Stress testing: run as many items, users, etc into the application and see how much it takes to break
- Purpose: Testing that involves a complete, integrated end to end system test that evaluates and accesses the system's compliance with the specified test cases requirements


### 1.2 Test Selection

Use cases will be created and from there our initial test cases will be drawn

### 1.3 Adequacy criterion:

This criteria is a prediicate for how the program, test suite is expressed. This predicate will be coonsidered true or false based on the following questions:
- Does the criterion satisfy the program specifixations?
- Does the criterion satisfy every test obligation by at minimum one test case in the suite?

### 1.4 Bug Tracking

For Bug Trackin, we will use the Atlassian product called JIRA. The Bug report will include the following information:
- Descriptive title, build version, how to reporduce, 
- bug prioritization where it will notify us the app breakability of the bug

### 1.5 Technology

The Technologies used for testing will be but not limited to Espresso and JUnit. 
- Espresso is the UI test frameowrk used to simulate the UI tests for the andriod app
- JUnit will be used to test the actual java scripts within the app running the main functionalities 

## 2 Test Cases

###Job

Job Offer Add/Edit information: 
- App is open to default page which is an empty current Job/Job Offer Field

| Purpose                       | Steps                                                                                                                                                          | Expected Results                       | Actual Results | Pass/Fail | Other |
|-------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------|----------------|-----------|-------|
| 1. Create Initial Job         | Press the 'add' Current Job Button, <br>go through the field steps and then <br>click confirm when every field is filled out                                   | Successfully adds the current job      |                |           |       |
| 2. Edit Current Job           | Press the 'edit' Button on the Current<br> Job Page and edit the desired field                                                                                 | Successfully updates the current job   |                |           |       |
| 3. Create Job Offer           | Press the 'plus' icon on the Job Offers<br> Page and go through all the same fields<br> as the current job page                                                | Successfully creates a new job offer   |                |           |       |
| 4. Edit Job Offer             | Press the 'edit' icon on the Selected<br> Job Offer and edit the desired field                                                                                 | Successfully updates the specified job |                |           |       |
| 5. Delete Job Offer           | Press the 'trash' icon on the Selected<br> Job Offer and delete that Job Offer                                                                                 | Successfully deletes the selected job  |                |           |       |
| 6. Delete multiple Job Offers | Select the 'select multiple' button and<br> then hit the trash icon and a Dialogue<br> will come up asking if you waned to confirm <br>the following selection | Successfully deletes selected jobs     |                |           |       |

###Comparison

Job Offer Comparison Page: 
- App is open with the default page which has two Jobs read for comparison

| Purpose                                                                     | Steps                                                                                                                             | Expected Results                                               | Actual Results | Pass/Fail | Other |
|-----------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------|----------------|-----------|-------|
| 7. Select Inital Job For<br>Comparison                                      | Select one of the jobs displayed from all the<br>jobs in the list of jobs presented before you                                    | Successfully select the first job to <br>compare               |                |           |       |
| 8. Select Second Job For<br>Comparison                                      | Select one of the jobs that is not the initial<br>selected job from the list of jobs                                              | Successfully select the second job to <br>compare              |                |           |       |
| 9. Apply Variable Filters                                                   | Press the 'filter' icon which will take you<br>to a drop down checkbox list where you can <br>select one or more filters to apply | Successfully apply and calculate score <br>per selected filter |                |           |       |
| 10. Check to make sure Job's<br>get suggested based off calculated<br>score | Press the 'calculate' icon <br>on the Job comparison page to rank all the <br>jobs                                                | Successfully rank jobs selected                                |                |           |       |
| 11. Reset all Filters                                                       | Press the 'reset' icon on the <br>comparison page to reset all the applied <br>filters                                            | Successfully reset all the filters                             |                |           |       |

###Field Accuracy

|Purpose       |Steps                                                  |Expected Result            |Actual Result|P/F info|Other|
|:-------------|:-----------------------------------------------------:|:--------------------------|:------------|:-------|:----|
|12. Check Curent Job Fields| Enter the desired information per field | The item will not through any toaster errors because of invalid symbols/values | | |
|13. Check Job Offer Fields | Enter the desired information per field | The item will not through any toaster errors because of invalid symbols/values | | |
