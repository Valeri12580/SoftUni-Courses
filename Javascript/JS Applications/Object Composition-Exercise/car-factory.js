function solve(object) {

    let engines = 
        [{ power: 90, volume: 1800 } ,
             { power: 120, volume: 2400 },
           { power: 200, volume: 3500 } ]

        
    


    return {
            model: object.model,
            engine:engines.find(e=>e.power>=object.power),
            carriage: {
                type: object.carriage,
                color: object.color
            },
            wheels: new Array(4).fill(object.wheelsize % 2 == 1 ? object.wheelsize : --object.wheelsize)
        }





    }

    console.log(solve({
        model: 'VW Golf II',
        power: 90,
        color: 'blue',
        carriage: 'hatchback',
        wheelsize: 14
    }));
