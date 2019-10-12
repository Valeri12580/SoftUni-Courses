func = () => {
    const ing = {
      protein: 0,
      carbohydrate: 0,
      fat: 0,
      flavour: 0,
    };
   
    const recipes = {
      apple: { carbohydrate: 1, flavour: 2 },
      lemonade: { carbohydrate: 10, flavour: 20 },
      burger: { carbohydrate: 5, fat: 7, flavour: 3 },
      turkey: { protein: 10, carbohydrate: 10, fat: 10, flavour: 10 },
      eggs: { protein: 5, fat: 1, flavour: 1 },
    };
   
    commands = {
      restock: (x, y) => {
        ing[x] += Number(y);
        return 'Success';
      },
   
      prepare: (x, y) => {
        let result = 'Success';
        let success = true;
        recipe = Object.entries(recipes[x]);
   
        for (let elem of recipe) {
          if (ing[elem[0]] < elem[1] * y) {
            success = false;
            result = `Error: not enough ${elem[0]} in stock`;
            break;
          }
        }
   
        if (success) {
          recipe.forEach(e => (ing[e[0]] -= e[1] * y));
        }
        return result;
      },
   
      report: () =>
        Object.entries(ing)
          .map(e => `${e[0]}=${e[1]}`)
          .join(' '),
    };
   
    return x => {
      const [command, element, quantity] = x.split(' ');
      return commands[command](element, quantity);
    };
  }
  