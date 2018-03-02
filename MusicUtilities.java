package hw5;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import hw5.speccheck.Accidental;
import hw5.speccheck.Duration;
import hw5.speccheck.Letter;
import hw5.speccheck.Note;
import hw5.speccheck.WavIO;

public class MusicUtilities {

	public static Note[] getScale(Note rootNote, int[] offsets) throws IOException {
		Note[] scale = new Note[offsets.length + 1];

		scale[0] = new Note(rootNote.getHalfstepID(), rootNote.getDuration(), rootNote.getAmplitude(),
				rootNote.isDotted());

		for (int i = 1; i < scale.length; i++) {
			scale[i] = new Note(scale[i - 1].getHalfstepID() + offsets[i - 1], rootNote.getDuration(),
					rootNote.getAmplitude(), rootNote.isDotted());
		}
		// System.out.println(Arrays.toString(scale));
		// String path = "C:/Users/sarah/Desktop/scale.wav";
		// WavIO.write(scale, 200, path);
		// Desktop desktop = Desktop.getDesktop();
		// desktop.open(new File(path));
		return scale;
	}

	public static Note[] getMajorScale(Note rootNote) throws IOException {
		int[] offsets = { 2, 2, 1, 2, 2, 2, 1 };
		Note[] majorScale = getScale(rootNote, offsets);
		return majorScale;
	}

	public static Note[] getMinorPentatonicBluesScale(Note rootNote) throws IOException {
		int[] offsets = { 3, 2, 2, 3, 2 };
		Note[] minorPentatonicBluesScale = getScale(rootNote, offsets);
		return minorPentatonicBluesScale;
	}

	public static Note[] getBluesScale(Note rootNote) throws IOException {
		int[] offsets = { 3, 2, 1, 1, 3, 2 };
		Note[] bluesScale = getScale(rootNote, offsets);
		return bluesScale;
	}

	public static Note[] getNaturalMinorScale(Note rootNote) throws IOException {
		int[] offsets = { 2, 1, 2, 2, 1, 2, 2 };
		Note[] naturalMinorScale = getScale(rootNote, offsets);
		return naturalMinorScale;
	}

	public static Note[] join(Note[] firstNotes, Note[] secondNotes) {
		Note[] joint = new Note[firstNotes.length + secondNotes.length];
		for (int i = 0; i < firstNotes.length; i++) {
			joint[i] = firstNotes[i];
		}
		for (int i = 0; i < secondNotes.length; i++) {
			joint[firstNotes.length + i] = secondNotes[i];
		}
		return joint;

	}

	public static Note[] repeat(Note[] notes, int nCycles) {
		Note[] repeated = new Note[notes.length * nCycles];
		repeated = Arrays.copyOf(notes, repeated.length);
		for (int last = notes.length; last != 0 && last < repeated.length; last <<= 1) {
			System.arraycopy(repeated, 0, repeated, last, Math.min(last << 1, repeated.length) - last);
		}
		return repeated;
	}

	public static Note[] ramplify(Note[] notes, double startAmp, double endAmp) {
		Note[] amp = new Note[notes.length];
		double ampStep = (endAmp - startAmp) / (notes.length - 1);
		amp[0] = new Note(notes[0].getHalfstepID(), notes[0].getDuration(), startAmp, notes[0].isDotted());
		for (int i = 1; i < notes.length; i++) {
			amp[i] = new Note(notes[i].getHalfstepID(), notes[i].getDuration(), amp[i - 1].getAmplitude() + ampStep,
					notes[i].isDotted());
		}

		return amp;

	}

	public static Note[] reverse(Note[] notes) {
		Note[] reversed = new Note[notes.length];
		for (int i = 0; i < notes.length; i++) {
			reversed[i] = notes[notes.length - 1 - i];
		}
		return reversed;
	}

	public static Note[] transpose(Note[] notes, Note rootNote) {
		Note[] transposed = new Note[notes.length];
		int shift = (rootNote.getHalfstepID() - notes[0].getHalfstepID());
		for (int i = 0; i < notes.length; i++) {
			transposed[i] = new Note(notes[i].getHalfstepID() + shift, notes[i].getDuration(), notes[i].getAmplitude(),
					notes[i].isDotted());
		}
		return transposed;

	}

	public static Note[] invert(Note[] notes, Note pivotNote) {
		Note[] inverted = new Note[notes.length];
		for (int i = 0; i < notes.length; i++) {
			int shift = -1 * (notes[i].getHalfstepID() - pivotNote.getHalfstepID());
			inverted[i] = new Note(pivotNote.getHalfstepID() + shift, notes[i].getDuration(), notes[i].getAmplitude(),
					notes[i].isDotted());
		}
		return inverted;
	}

	public static void jaws() throws IOException {
		Note[] jaws = { new Note(Letter.D, 4, Duration.QUARTER),
				new Note(Letter.E, Accidental.FLAT, 4, Duration.QUARTER), new Note(Letter.D, 4, Duration.QUARTER),
				new Note(Letter.E, Accidental.FLAT, 4, Duration.QUARTER), new Note(Letter.D, 4, Duration.QUARTER),
				new Note(Letter.E, Accidental.FLAT, 2, Duration.QUARTER), new Note(Letter.D, 4, Duration.QUARTER),
				new Note(Letter.E, Accidental.FLAT, 2, Duration.EIGHTH), new Note(Letter.D, 4, Duration.EIGHTH),
				new Note(Letter.D, 4, Duration.EIGHTH), new Note(Letter.E, Accidental.FLAT, 4, Duration.EIGHTH),
				new Note(Letter.D, 4, Duration.EIGHTH), new Note(Letter.E, Accidental.FLAT, 4, Duration.EIGHTH),
				new Note(Letter.D, 4, Duration.SIXTEENTH), new Note(Letter.D, 4, Duration.SIXTEENTH),
				new Note(Letter.E, Accidental.FLAT, 4, Duration.SIXTEENTH), new Note(Letter.D, 4, Duration.SIXTEENTH),
				new Note(Letter.D, 4, Duration.SIXTEENTH), new Note(Letter.E, Accidental.FLAT, 4, Duration.SIXTEENTH),
				new Note(Letter.D, 4, Duration.THIRTYSECOND), new Note(Letter.E, Accidental.FLAT, 4, Duration.THIRTYSECOND),
				new Note(Letter.D, 4, Duration.THIRTYSECOND),

		};
		String path = "C:/Users/sarah/Desktop/jaws.wav";
		WavIO.write(jaws, 100, path);
		Desktop desktop = Desktop.getDesktop();
		desktop.open(new File(path));
	}

}