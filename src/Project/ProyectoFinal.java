package Project;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ProyectoFinal {

	public static void main(String[] args) {

		DateTimeFormatter formato12Horas = DateTimeFormatter.ofPattern("hh:mm");

		double[][] costesAcumulado = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

		for (int turno = 1; turno <= 60; turno++) {
			System.out.println("\nTurno: " + turno);
			for (int equipo = 3; equipo <= 6; equipo++) {

				// ENCABEZADO DE LA TABLA
				System.out.println(
						"\nOperaciones de descarga durante el turno " + turno + " (equipo de " + equipo + " personas)");
				System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n", "Num. Aleat",
						"T / llegada", "T. de llegada", "Inic. Serv.", " Num. Aleat", "T. de Serv", "Term. de Serv",
						"Ocio personal", "T. esp camion", "Long. cola");

				// Se calcula todos los camiones que llegaran
				ArrayList<Double> randomsLlegadas = new ArrayList<>();
				ArrayList<Integer> tiemposEntreLlegadas = new ArrayList<>();
				ArrayList<LocalTime> tiemposDeLlegadas = new ArrayList<>();
				LocalTime horaDeLlegada = LocalTime.of(23, 0, 0);
				int llegadas = 0;
				Double randomLlegada = Math.random();
				int tiempoEntreLlegada = tiempoEntreLlegadas(randomLlegada);
				horaDeLlegada = horaDeLlegada.plusMinutes(tiempoEntreLlegada);
				while (true) {
					if ((horaDeLlegada.getHour() < 20) && (horaDeLlegada.getHour() > 7
							|| (horaDeLlegada.getHour() >= 7 && horaDeLlegada.getMinute() >= 30))) {
						break;
					}
					randomsLlegadas.add(randomLlegada);
					tiemposEntreLlegadas.add(tiempoEntreLlegada);
					tiemposDeLlegadas.add(horaDeLlegada);
					llegadas++;

					// Siguiente
					randomLlegada = Math.random();
					tiempoEntreLlegada = tiempoEntreLlegadas(randomLlegada);
					horaDeLlegada = horaDeLlegada.plusMinutes(tiempoEntreLlegada);
				}

				// CALCULAR LA COLA INICIAL
				double randomTiempoServicio;
				int tiempoDeServicio;
				double randomColaInicial = Math.random();
				int longCola = camionesIniciales(randomColaInicial);

				LocalTime horaServicio = LocalTime.of(23, 0, 0);
				LocalTime horaFinServicio = LocalTime.of(23, 0, 0);

				// Si no hubo camiones esperando
				if (longCola == 0) {
					System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n",
							"", "", "11:00", horaServicio.format(formato12Horas), "-", "-",
							horaFinServicio.format(formato12Horas), "-", "-", longCola);
				} else {
					randomTiempoServicio = Math.random();
					tiempoDeServicio = tiempoServicio(equipo, randomTiempoServicio);
					horaFinServicio = horaServicio.plusMinutes(tiempoDeServicio);
					System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n",
							"", "", "11:00", horaServicio.format(formato12Horas),
							String.format("%.5f", randomTiempoServicio), tiempoDeServicio,
							horaFinServicio.format(formato12Horas), "-", "-", longCola);
					longCola--;
				}

				// Checar si hay camiones en cola antes de la llegada de otro camion
				while (longCola != 0 && horaFinServicio.isBefore(tiemposDeLlegadas.get(0))) {
					randomTiempoServicio = Math.random();
					tiempoDeServicio = tiempoServicio(equipo, randomTiempoServicio);
					horaServicio = horaFinServicio;
					horaFinServicio = horaServicio.plusMinutes(tiempoDeServicio);
					longCola--;
				}

				boolean lonche = false;
				int ocioPersonal = 0, esperaCamion = 0, esperaCamionAcumulada = 0;

				for (int i = 0; i < llegadas; i++) {
					// Checar si es hora de lonche
					if (horaFinServicio.isAfter(LocalTime.of(3, 0, 0))
							&& horaFinServicio.isBefore(LocalTime.of(20, 0, 0)) && !lonche) {
						// System.out.println("HORA DE LONCHE");
						horaFinServicio = horaFinServicio.plusMinutes(30);
						lonche = true;
					}

					// Calcular ocioPersonal o esperaCamion
					if (horaFinServicio.isBefore(tiemposDeLlegadas.get(i))
							|| (horaFinServicio.getHour() > 20 && tiemposDeLlegadas.get(i).getHour() < 20)) {
						ocioPersonal = (int) ChronoUnit.MINUTES.between(horaFinServicio, tiemposDeLlegadas.get(i));
						if (horaFinServicio.getHour() > 20 && tiemposDeLlegadas.get(i).getHour() < 20) {
							ocioPersonal += 1440;
						}
						esperaCamion = 0;
						horaFinServicio = tiemposDeLlegadas.get(i);
					} else {
						esperaCamion = (int) ChronoUnit.MINUTES.between(tiemposDeLlegadas.get(i), horaFinServicio);
						esperaCamionAcumulada += esperaCamion;
						ocioPersonal = 0;
					}

					// Calcular la longitud de cola
					longCola = 0;
					int j = i;
					while (j != llegadas && ocioPersonal == 0 && !horaFinServicio.isBefore(tiemposDeLlegadas.get(j))) {
						if (horaFinServicio.getHour() > 20 && tiemposDeLlegadas.get(j).getHour() < 20)
							break;
						longCola++;
						j++;
					}

					horaServicio = horaFinServicio;
					randomTiempoServicio = Math.random();
					tiempoDeServicio = tiempoServicio(equipo, randomTiempoServicio);
					horaFinServicio = horaServicio.plusMinutes(tiempoDeServicio);

					System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n",
							String.format("%.5f", randomsLlegadas.get(i)), tiemposEntreLlegadas.get(i),
							tiemposDeLlegadas.get(i).format(formato12Horas), horaServicio.format(formato12Horas),
							String.format("%.5f", randomTiempoServicio), tiempoDeServicio,
							horaFinServicio.format(formato12Horas), ocioPersonal, esperaCamion, longCola);
					longCola--;
				}
				while (longCola != -1) {
					randomTiempoServicio = Math.random();
					tiempoDeServicio = tiempoServicio(equipo, randomTiempoServicio);
					horaServicio = horaFinServicio;
					horaFinServicio = horaServicio.plusMinutes(tiempoDeServicio);
					longCola--;
				}

				// Calcular el tiempo extra
				int tiempoExtra = (int) ChronoUnit.MINUTES.between(LocalTime.of(7, 30, 0), horaFinServicio);
				double salarioNormal = equipo * 8 * 25;
				double salarioExtra = 0;
				double tiempoAlmacen = 8.5;
				if (tiempoExtra > 0) {
					salarioExtra = 37.5 * equipo * (tiempoExtra / 60);
					tiempoAlmacen += (tiempoExtra / 60);
				}
				double operacionAlmacen = 500 * tiempoAlmacen;
				double totalEsperaCamion = 100 * (esperaCamionAcumulada / 60);

				double costoTotal = salarioNormal + salarioExtra + operacionAlmacen + totalEsperaCamion;

				costesAcumulado[equipo - 3][0] += salarioNormal;
				costesAcumulado[equipo - 3][1] += salarioExtra;
				costesAcumulado[equipo - 3][2] += totalEsperaCamion;
				costesAcumulado[equipo - 3][3] += operacionAlmacen;
				costesAcumulado[equipo - 3][4] += costoTotal;

			}

		}

		System.out.println();
		int c = 3;
		System.out.println("COSTES FINALES");
		System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
				"Tam. Equipo", "Sal. Normal", "Sal. Extra", "Ocio Camion", "Op. de Almacen", "Costos Totales");
		for (int i = 0; i < 4; i++) {
			System.out.printf("%-15s|", c);
			for (int j = 0; j < 5; j++) {
				System.out.printf("%-15s|", String.format("%.2f", costesAcumulado[i][j] / 60));
			}
			System.out.println();
			c++;
		}
		System.out.println();

	}

	public static int camionesIniciales(double numAleat) {
		if (numAleat < 0.5)
			return 0;
		if (numAleat < 0.75)
			return 1;
		if (numAleat < 0.90)
			return 2;
		return 3;
	}

	public static int tiempoEntreLlegadas(double numAleat) {
		if (numAleat < 0.02)
			return 20;
		if (numAleat < 0.10)
			return 25;
		if (numAleat < 0.22)
			return 30;
		if (numAleat < 0.47)
			return 35;
		if (numAleat < 0.67)
			return 40;
		if (numAleat < 0.82)
			return 45;
		if (numAleat < 0.92)
			return 50;
		if (numAleat < 0.97)
			return 55;
		return 60;
	}

	public static int tiempoServicio(int tamEquipo, double numAleat) {
		if (tamEquipo == 3) {
			if (numAleat < 0.05)
				return 20;
			if (numAleat < 0.15)
				return 25;
			if (numAleat < 0.35)
				return 30;
			if (numAleat < 0.60)
				return 35;
			if (numAleat < 0.72)
				return 40;
			if (numAleat < 0.82)
				return 45;
			if (numAleat < 0.90)
				return 50;
			if (numAleat < 0.96)
				return 55;
			return 60;
		}
		if (tamEquipo == 4) {
			if (numAleat < 0.05)
				return 15;
			if (numAleat < 0.20)
				return 20;
			if (numAleat < 0.40)
				return 25;
			if (numAleat < 0.60)
				return 30;
			if (numAleat < 0.75)
				return 35;
			if (numAleat < 0.87)
				return 40;
			if (numAleat < 0.95)
				return 45;
			if (numAleat < 0.99)
				return 50;
			return 55;
		}
		if (tamEquipo == 5) {
			if (numAleat < 0.10)
				return 10;
			if (numAleat < 0.28)
				return 15;
			if (numAleat < 0.50)
				return 20;
			if (numAleat < 0.68)
				return 25;
			if (numAleat < 0.78)
				return 30;
			if (numAleat < 0.86)
				return 35;
			if (numAleat < 0.92)
				return 40;
			if (numAleat < 0.97)
				return 45;
			return 50;
		}
		if (tamEquipo == 6) {
			if (numAleat < 0.12)
				return 5;
			if (numAleat < 0.27)
				return 10;
			if (numAleat < 0.53)
				return 15;
			if (numAleat < 0.68)
				return 20;
			if (numAleat < 0.80)
				return 25;
			if (numAleat < 0.88)
				return 30;
			if (numAleat < 0.94)
				return 35;
			if (numAleat < 0.98)
				return 40;
			return 45;
		}
		return 0;
	}
}
