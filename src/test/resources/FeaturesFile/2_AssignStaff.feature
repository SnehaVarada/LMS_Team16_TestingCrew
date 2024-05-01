

  @tag2
  Scenario: Validate Assign Staff Popup window
    Given Admin is in manage user page
    When Admin clicks "Assign Staff" button
    Then Admin should see a pop up open for assign staff details with empty form along
     with Save and Cancel button and close (X) icon on the top right corner of the window
