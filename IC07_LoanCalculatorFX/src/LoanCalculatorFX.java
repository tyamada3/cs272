import java.text.NumberFormat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculatorFX extends Application
{

    // Member variables should be the nodes we interact with
    private TextField mInterestRateTF = new TextField();
    private TextField mYearsTF = new TextField();
    private TextField mLoanAmountTF = new TextField();
    private TextField mMonthlyPaymentTF = new TextField();
    private TextField mTotalPaymentTF = new TextField();

    private Button mClearButton = new Button("Clear");
    private Button mCalculateButton = new Button("Calculate");

    private GridPane mGridPane = new GridPane();


    public static void main(String[] args)
    {

        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Fill the Grid
        mGridPane.add(new Label("Annual Interest Rate:"), 0, 0);
        mGridPane.add(mInterestRateTF, 1, 0);
        mGridPane.add(new Label("Number of Years:"), 0,  1);
        mGridPane.add(mYearsTF, 1, 1);
        mGridPane.add(new Label("Loan Amount:"), 0,  2);
        mGridPane.add(mLoanAmountTF, 1, 2);
        mGridPane.add(new Label("Monthly Payment:"), 0,  3);
        mGridPane.add(mMonthlyPaymentTF, 1, 3);
        mGridPane.add(new Label("Total Payment:"), 0,  4);
        mGridPane.add(mTotalPaymentTF, 1, 4);

        mGridPane.add(mClearButton, 0,  5);
        mGridPane.add(mCalculateButton, 1,  5);


        // Define event handler for each button(when clicked)
        mClearButton.setOnAction(e -> clear());
        mCalculateButton.setOnAction(e -> calculate());

        //Align the GridPane to be centered
        mGridPane.setAlignment(Pos.CENTER);
        mGridPane.setHgap(5);
        mGridPane.setVgap(5);

        mInterestRateTF.setAlignment(Pos.CENTER_RIGHT);
        mYearsTF.setAlignment(Pos.CENTER_RIGHT);
        mLoanAmountTF.setAlignment(Pos.CENTER_RIGHT);
        mMonthlyPaymentTF.setAlignment(Pos.CENTER_RIGHT);
        mTotalPaymentTF.setAlignment(Pos.CENTER_RIGHT);

        mMonthlyPaymentTF.setEditable(false);
        mTotalPaymentTF.setEditable(false);



        Scene scene = new Scene(mGridPane, 400, 250);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Object calculate()
    {
        //r = 4.5 / 1200 or 4.5 / 100 / 12
        double r = Double.parseDouble(mInterestRateTF.getText()) / 100 / 12;
        double period = Double.parseDouble(mYearsTF.getText()) * 12;
        double loanAmount = Double.parseDouble(mLoanAmountTF.getText());

        double monthlyPayment = (r * loanAmount) / (1 - Math.pow(1 + r, period * -1));

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        mMonthlyPaymentTF.setText(currency.format(monthlyPayment));
        mTotalPaymentTF.setText(currency.format(monthlyPayment * period));

        return null;
    }

    private Object clear()
    {
        //Clear all text fields
        mInterestRateTF.clear();
        mYearsTF.clear();
        mLoanAmountTF.clear();
        mMonthlyPaymentTF.clear();
        mTotalPaymentTF.clear();

        //Reset the focus back to interest rate
        mInterestRateTF.requestFocus();

        return null;
    }

}
