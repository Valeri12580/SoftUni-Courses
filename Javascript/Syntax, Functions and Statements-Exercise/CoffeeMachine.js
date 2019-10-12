function solve(array) {
    let totalIncome=0;


    for (let i = 0; i < array.length; i++) {
        let singePurchase = array[i].split(", ");
        let wallet = Number(singePurchase[0]);
        let price = 0;
        let type = singePurchase[1];

        switch (type) {
            case "coffee":
                if(singePurchase.length===4) {

                    if (singePurchase[2] === "caffeine") {
                        price += 0.80;
                    } else {
                        price += 0.90;
                    }
                    if (Number(singePurchase[3]) !== 0) {
                        price += 0.10;
                    }

                }else if (singePurchase.length===5){
                    if (singePurchase[2] === "caffeine") {
                        price += 0.80;
                    } else {
                        price += 0.90;
                    }
                    if (Number (singePurchase[4]) !== 0) {
                        price += 0.10;
                    }
                    if (typeof singePurchase[3] === "string") {
                        price = Number((price * 1.1).toFixed(1))
                    }
                }

                break;

            case "tea":
                price += 0.80
                if (singePurchase.length === 3) {
                    if (Number(singePurchase[2]) !== 0) {
                        price += 0.10;
                    }
                } else if(singePurchase.length===4){
                    if (typeof singePurchase[2] === "string") {
                        price = Number((price * 1.1).toFixed(1))
                    }
                    if (Number(singePurchase[3]) !== 0) {
                        price += 0.10;
                    }
                }



                break;
        }


        if (wallet >= price) {
            totalIncome+=price;
            console.log(`You ordered ${type}. Price: $${price.toFixed(2)} Change: $${(wallet - price).toFixed(2)}`)
        } else {
            console.log(`Not enough money for ${type}. Need $${(price - wallet).toFixed(2)} more.`)
        }

    }
        console.log(`Income Report: $${totalIncome.toFixed(2)}`)
}


solve(['8.00, coffee, decaf, 4', '1.00, tea, 2'])