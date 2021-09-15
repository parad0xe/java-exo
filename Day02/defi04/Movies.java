
class Movies {
	public static void main(String[] args) {
		String[] movies = {
			"Indiana Jones et le Royaume du Crâne de Cristal",
			"Indiana Jones et la Dernière Croisade",
			"Indiana Jones et le Temple maudit"
		};

		String[][] actors = {
			{"Harrison Ford", "Shia LaBeouf", "Karen Allen"},
			{"Harrison Ford", "Sean Connery", "Denholm Elliott"},
			{"Harrison Ford", "Kate Capshaw", "Jonathan Ke Quan"}
		};


		for(int i = 0; i < movies.length; i++) {
			System.out.print("Dans le film " + movies[i] + ", les acteurs principaux sont: ");

			for(int j = 0; j < actors.length; j++) {
				System.out.print(actors[i][j]);
				if(j < actors.length - 1) System.out.print(", ");
			}

			System.out.println("\n");
		}
    }
}