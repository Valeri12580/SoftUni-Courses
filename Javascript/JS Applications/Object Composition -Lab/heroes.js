function solve() {

    
        let mage = (name) => {
            let state= {
                name, health: 100, mana: 100, cast: function (name) {
                 console.log(`${this.name} cast ${name}`);
                    
                    this.mana--;
                }
            }
            return state
        }

        let fighter=(name)=>{
            let state={
                name,
                health:100,
                stamina:100,
                fight:function(){
                    console.log(`${this.name} slashes at the foe!`);
                    
                        this.stamina--;
                }
             
            }
            return state;
        }

        return {mage:mage,
            fighter:fighter}
       


    
}

let create = solve();
create.
const scorcher = create.mage("Scorcher");
scorcher.cast("fireball")
scorcher.cast("thunder")
scorcher.cast("light")

const scorcher2 = create.fighter("Scorcher 2");
scorcher2.fight()

console.log(scorcher2.stamina);
console.log(scorcher.mana);

